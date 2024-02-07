package com.practice.jewerly.service.interfaces;

import com.practice.jewerly.dto.JewelDto;
import com.practice.jewerly.dto.MessageDto;
import com.practice.jewerly.model.Jewel;
import com.practice.jewerly.service.interfaces.generics.ICrudService;

import java.util.List;

public interface IJewelService extends ICrudService<JewelDto, Long> {
}
