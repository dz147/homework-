package com.nf.bookstore1.session;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class SessionFactory {

    // 为每个连接的 session 设置一个独立的 id，通过下面这个变量存取
    private final static String SESSION_KEY = "MY_SID";

    // 通过一个静态化的变量，保存为所有连接创建的 Session
    // 因为是静态的，所在，在服务器运行的过程中，它会一直存在
    private static Map<String, MySession> sessions = new HashMap<>();

    public static MySession getSession(HttpServletRequest req, HttpServletResponse resp) {
        String sid = null;
        MySession session = null;

        // 首先，从 cookie 中获取 session 的 id
        Cookie[] cookies = req.getCookies();
        if(cookies != null) {
            for (Cookie cookie : cookies) {
                if(cookie.getName().equals(SESSION_KEY)) {
                    sid = cookie.getValue();
                    break;
                }
            }
        }

        // 如果 cookie 中获取不到合适的 Session Id，说明当前请求是第一次访问
        // 这时就需要为其初始化 session 对象
        if (!checkSessionId(sid)) {
            // 生成随机且唯一的 session id
            sid = generateSessionId();
            // 创建新的 session 对象
            session = createNewSession(sid);
            // 在响应的时候，让浏览器在 cookie 里保存生成的 sid
            // 那么浏览器在下次请求的时候，会自动将这些 cookie 信息发送到服务器
            resp.addCookie(new Cookie(SESSION_KEY, sid));
        } else {
            // 如果能从 cookie 里获取合适的 session id，
            // 那么就尝试从 sessions 里获取这个请求对应的 session 对象
            session = sessions.get(sid);

            // 如果拿到的是空，说明不存在，就需要重新创建
            if(session == null) {
                session = createNewSession(sid);
            }
        }

        // 将获取或者新创建的 session 返回，任务完成
        return session;
    }

    /**
     * 检查 sid 格式是否正确
     */
    private static boolean checkSessionId(String sid) {
        return !(sid == null || sid.isEmpty());
    }

    /**
     * 生成随机的唯一字符串，作为 session id 使用
     */
    private static String generateSessionId() {
        return String.valueOf(UUID.randomUUID());
    }

    /**
     * 创建新的 session，并将其保存到 sessions 里面
     */
    private static MySession createNewSession (String sid) {
        MySession session = new MemorySession(sid);
        sessions.put(sid, session);
        return session;
    }
}
