package com.css.dataexchangesystem.mapper;

import com.css.dataexchangesystem.entity.User;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserMapper {
    User Sel(int id);
    List getUserList();
}
