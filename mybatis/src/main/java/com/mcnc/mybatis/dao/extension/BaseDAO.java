package com.mcnc.mybatis.dao.extension;

import java.util.List;

import com.mcnc.mybatis.dto.StudentDTO;

public interface BaseDAO {
	List< StudentDTO > getStudents();
}
