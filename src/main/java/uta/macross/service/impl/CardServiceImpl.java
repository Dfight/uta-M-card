package uta.macross.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import uta.macross.dao.CardDao;
import uta.macross.entry.*;
import uta.macross.service.CardService;

@Service("cardService")
public class CardServiceImpl implements CardService {
    @Autowired
    public CardDao cardDao;
    public int addCard(card card) {
        return cardDao.addCard(card);
    }

    public int addCardOpus(opus_card opusCard) {
        return cardDao.addCardOpus(opusCard);
    }

    public int addCardAttr(attrCard attrCard) {
        return cardDao.addCardAttr(attrCard);
    }

    public int addCardClothing(cardClothingFighter cardClothingFighter) {
        return cardDao.addCardClothing(cardClothingFighter);
    }

    public int addCardFighter(cardClothingFighter cardClothingFighter) {
        return cardDao.addCardFighter(cardClothingFighter);
    }

    public int addCardInit(cardInit cardInit) {
        return cardDao.addCardInit(cardInit);
    }

    public int addCardMax(cardMax cardMax) {
        return cardDao.addCardMax(cardMax);
    }

    public int addCardSinger(singer_card singer_card) {
        return cardDao.addCardSinger(singer_card);
    }
}
