package spittr.email;

import spittr.domain.Spittle;

import javax.mail.MessagingException;

public interface SpitterMailService {

    public abstract void sendSimpleSpittleEmail(String to, Spittle spittle);

    public abstract void sendSpittleEmailWithAttachment(String to, Spittle spittle)
            throws MessagingException;

}