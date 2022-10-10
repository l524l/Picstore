package site.l524l.picstore.converters;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import site.l524l.picstore.media.Media;
import site.l524l.picstore.objects.PublicMedia;

@Component
public class PublicMediaConverter implements Converter<Media, PublicMedia> {
	
	
	@Value("${storage.images.webpath}")
	private String weburl;
	
	@Override
	public PublicMedia convert(Media source) {
		return new PublicMedia(weburl + source.getId().toString() + source.getExtantion());
	}

}
