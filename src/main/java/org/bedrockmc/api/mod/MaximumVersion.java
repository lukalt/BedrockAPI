package org.bedrockmc.api.mod;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import org.bedrockmc.api.MinecraftVersion;

@Target({ java.lang.annotation.ElementType.TYPE })
@Retention(RetentionPolicy.RUNTIME)
public @interface MaximumVersion {

	public MinecraftVersion maxVersion();
	
}
