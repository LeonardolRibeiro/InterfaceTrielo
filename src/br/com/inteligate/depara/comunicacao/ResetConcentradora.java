package br.com.inteligate.depara.comunicacao;

import java.io.IOException;

public class ResetConcentradora {


	public static void main(String[] args) {

		ResetConcentradora resetConcentradora = new ResetConcentradora();
		try {
			resetConcentradora.reset();
		} catch (Exception e) {

			e.printStackTrace();
		}
	}
	
	private final String service = "jvSrvMDC4com";
	
	public ResetConcentradora() {

	}

	public void reset() throws Exception{
		
		String comando = "cmd /c net stop \"" + service + "\"";
		Process runtimeProcess = Runtime.getRuntime().exec(comando);
		int completo = runtimeProcess.waitFor();
		
		System.out.println("Resultado stop:" + completo);
		
		if (completo != 0) {
			throw new Exception("Interromper processo:" + service + " falhou");
		}		

		comando = "cmd /c net start \"" + service + "\"";
		runtimeProcess = Runtime.getRuntime().exec(comando);
		completo = runtimeProcess.waitFor();
		
		System.out.println("Resultado start:" + completo);
		
		if (completo != 0) {
			throw new Exception("Iniciar processo:0" + service + "falhou");
		}		
	}

}
