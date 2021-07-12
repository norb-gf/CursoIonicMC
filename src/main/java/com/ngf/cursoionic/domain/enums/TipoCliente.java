package com.ngf.cursoionic.domain.enums;

public enum TipoCliente {

	PESSSOA_FíSICA (5,"PF"),
	PESSOA_JURÍDICA(10,"PJ");
	
	private int cod;
	private String descr;
	
	TipoCliente (int cod, String descr){
		this.cod = cod;
		this.descr = descr; 
	}

	public int getCod() {
		return cod;
	}
	
	public String getDescr() {
		return descr;
	}
	public static TipoCliente toEnum(Integer cod) {
		if (cod == null) {
			return null;
		}
		for (TipoCliente x : TipoCliente.values()) {
			if(cod.equals(x.getCod())) {
				return x;
			}
		}
		
		throw new IllegalArgumentException("Id invalido" + cod);
	}
	
	
	
}
