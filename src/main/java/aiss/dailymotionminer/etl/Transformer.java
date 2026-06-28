package aiss.dailymotionminer.etl;

import aiss.dailymotionminer.model.dailymotion.Caption;
import aiss.dailymotionminer.model.dailymotion.Channel;
import aiss.dailymotionminer.model.dailymotion.Video;
import aiss.dailymotionminer.model.videominer.*;

import java.util.ArrayList;
import java.util.List;

public class Transformer {


    public static VMChannel transformChannel(Channel dmChannel) {
        if (dmChannel == null) return null;

        VMChannel vmChannel = new VMChannel();
        vmChannel.setId(dmChannel.getId());
        vmChannel.setName(dmChannel.getName());
        vmChannel.setDescription(dmChannel.getDescription());

        // Convertimos el Integer de Dailymotion a String (si tu VMChannel pide String)
        if (dmChannel.getCreatedTime() != null) {
            vmChannel.setCreatedTime(dmChannel.getCreatedTime().toString());
        }

        // Inicializamos la lista de vídeos para evitar NullPointerException
        vmChannel.setVideos(new ArrayList<>());

        return vmChannel;
    }
    public static List<VMThumbnail> transformThumbnails(Video dmVideo) {
        List<VMThumbnail> thumbnails = new ArrayList<>();

        if (dmVideo.getThumbnailUrl() != null) {
            VMThumbnail large = new VMThumbnail();
            large.setUrl(dmVideo.getThumbnailUrl());
            large.setSizeType("large");
            thumbnails.add(large);
        }

        if (dmVideo.getThumbnail240Url() != null) {
            VMThumbnail small = new VMThumbnail();
            small.setUrl(dmVideo.getThumbnail240Url());
            small.setSizeType("small");
            thumbnails.add(small);
        }

        return thumbnails;
    }



    public static VMVideo transformVideo(Video dmVideo) {
        if (dmVideo == null) return null;

        VMVideo vmVideo = new VMVideo();
        vmVideo.setId(dmVideo.getId());
        vmVideo.setName(dmVideo.getTitle()); // Usamos getTitle() de tu clase Video
        vmVideo.setDescription(dmVideo.getDescription());
        vmVideo.setThumbnails(transformThumbnails(dmVideo));

        if (dmVideo.getCreatedTime() != null) {
            vmVideo.setReleaseTime(dmVideo.getCreatedTime().toString());
        }


        List<VMCaption> vmCaptions = new ArrayList<>();
        if (dmVideo.getCaptions() != null) {
            for (Caption dmCaption : dmVideo.getCaptions()) {
                vmCaptions.add(transformCaption(dmCaption));
            }
        }
        vmVideo.setCaptions(vmCaptions);


        List<VMComment> vmComments = new ArrayList<>();
        if (dmVideo.getTags() != null) {
            for (String tag : dmVideo.getTags()) {
                VMComment vmComment = new VMComment();

                // Inventamos un ID aleatorio porque los tags no tienen ID
                vmComment.setId(java.util.UUID.randomUUID().toString());

                // Metemos la palabra del tag como texto del comentario
                vmComment.setText(tag);

                // Le asignamos la misma fecha de creación del vídeo
                if (dmVideo.getCreatedTime() != null) {
                    vmComment.setCreatedOn(dmVideo.getCreatedTime().toString());
                }

                vmComments.add(vmComment);
            }
        }
        vmVideo.setComments(vmComments);

        return vmVideo;
    }


    public static VMCaption transformCaption(Caption dmCaption) {
        if (dmCaption == null) return null;

        VMCaption vmCaption = new VMCaption();
        vmCaption.setId(dmCaption.getId());
        vmCaption.setName(dmCaption.getLanguage());
        vmCaption.setLanguage(dmCaption.getLanguage());

        return vmCaption;
    }
}
