package com.dz.Interface;

import com.dz.entity.OrderFrom;
import com.dz.entity.Positions;

import java.util.List;

public interface IpositionDAO {
    List<Positions> getPositions(int userid);
    boolean getAdd(Positions p);
}
