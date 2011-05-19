package br.com.mystudies.spring.property.placeholder.configurer;

/**
 * @author robson.o.d@gmail.com
 */
public class SystemConfigWindows implements SystemConfig {


	private SystemPropertiesConfig propertiesConfig;
	
	@Override
	public void configSystem() {
		
		System.out.println( "OS Name.....: " + propertiesConfig.getOsName());
		System.out.println( "CPU Name....: " + propertiesConfig.getCpuName());
		System.out.println( "CPU Speedy..: " + propertiesConfig.getCpuSpeedy());
		System.out.println( "RAM.........: " + propertiesConfig.getRam());
	}

	
	/**
	 * Metodo set do atributo propertiesConfig.
	 *
	 * @param propertiesConfig
	 */
	public void setPropertiesConfig(SystemPropertiesConfig propertiesConfig) {
		this.propertiesConfig = propertiesConfig;
	}

}
