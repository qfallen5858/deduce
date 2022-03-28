package com.kanq.deduce.web.service.impl;

import javax.annotation.Resource;

import com.kanq.deduce.common.dao.PlayDao;
import com.kanq.deduce.common.entity.Play;
import com.kanq.deduce.common.enums.PlayStateEnum;
import com.kanq.deduce.web.service.PlayService;
import com.kanq.deduce.web.vo.PlayVO;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PlayServiceImpl implements PlayService{

    @Autowired
    private PlayDao playDao;


    @Override
    public PlayVO beginPlay(Integer id) {
        Play playItem = playDao.selectById(id);
        if(playItem == null){
            return null;
        }
        playItem.setState(PlayStateEnum.PLAYING);
        playDao.updateById(playItem);
        PlayVO playVO = new PlayVO();
        BeanUtils.copyProperties(playItem, playVO);
        playVO.setState(playItem.getState().getValue());
        return playVO;
    }
    
}
