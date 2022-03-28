package com.kanq.deduce.web.service;

import com.kanq.deduce.web.vo.PlayVO;

public interface PlayService {
    
    PlayVO beginPlay(Integer id);

    PlayVO pausePlay(Integer id);

    PlayVO stopPlay(Integer id);

}


