package com.exam.service;

import com.exam.dto.AcceptDTO;
import com.exam.dto.PageDTO;

public interface AcceptService {
	public PageDTO selectList(int curPage);
	public int acceptAdd(AcceptDTO dto);
}
