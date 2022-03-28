package com.kanq.deduce.web.service.impl;

import javax.annotation.Resource;

import com.kanq.deduce.common.dao.PlayDao;
import com.kanq.deduce.common.entity.Play;
import com.kanq.deduce.common.enums.CodeEnum;
import com.kanq.deduce.common.enums.PlayStateEnum;
import com.kanq.deduce.web.exception.KanqException;
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
        return updatePlayState(id, PlayStateEnum.PLAYING);
    }


    @Override
    public PlayVO pausePlay(Integer id) {
        return updatePlayState(id, PlayStateEnum.PAUSE);
    }


    @Override
    public PlayVO stopPlay(Integer id) {
        return updatePlayState(id, PlayStateEnum.END);
    }

    private PlayVO updatePlayState(Integer id, PlayStateEnum state) {
        Play playItem = playDao.selectById(id);
        if(playItem == null){
            throw new KanqException(CodeEnum.NOT_FOUND);
        }
        playItem.setState(state);
        playDao.updateById(playItem);
        PlayVO playVO = new PlayVO();
        playVO.setState(playItem.getState().getValue());
        return playVO;
    }
    
    
}
