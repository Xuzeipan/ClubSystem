package com.lx.mapper;

import com.lx.POJO.Club;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ClubMapper {
    List<Club> queryAllClub();
}
