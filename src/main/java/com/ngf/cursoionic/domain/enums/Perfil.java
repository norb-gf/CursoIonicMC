package com.ngf.cursoionic.domain.enums;

public enum Perfil {
	
	ADMIN(1,"ROLE_ADMIN"),
	CLIENTE(2,"ROLE_CLIENTE");

	private int cod;
	private String descr;
	
	private Perfil (int cod, String descr){
		this.cod = cod;
		this.descr = descr; 
	}

	public int getCod() {
		return cod;
	}
	
	public String getDescr() {
		return descr;
	}
	public static Perfil toEnum(Integer cod) {
		if (cod == null) {
			return null;
		}
		for (Perfil x : Perfil.values()) {
			if(cod.equals(x.getCod())) {
				return x;
			}
		}
		
		throw new IllegalArgumentException("Id invalido" + cod);
	}
	
	
}
