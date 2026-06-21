package com.actions;

import com.ai.dto.ChatIntentDTO;
import com.enums.AcaoChat;

public interface ChatAction {
    AcaoChat suporta();
    Object executar(Integer utilizadorId, ChatIntentDTO intent);
}
