package site.l524l.picstore.converters;

import java.util.HashSet;
import java.util.Set;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import site.l524l.picstore.user.Role;

@Component
public class RolesSetConverter implements Converter<Set<String>, Set<Role>> {

	@Override
	public Set<Role> convert(Set<String> source) {
		Set<Role> roles = new HashSet<>();
		
		source.forEach((x) -> roles.add(new Role(x)));
		
		
		return roles;
	}
}
