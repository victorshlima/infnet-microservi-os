package com.victation.AppLocacao.model.test;


import com.victation.AppLocacao.interfaces.IPrinter;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class AppImpressao {
	public static void relatorio (String mensagem, IPrinter printer) {
		System.out.println(mensagem);
		printer.impressao();
		
	}

	public static void main (String[] args)   {

		String systemDir = System.getProperty("user.dir");
		System.out.println(systemDir);
		String dir = systemDir+"//dev//";
		String arq = "locacoes.txt";
		String fileName =dir + arq;
		System.out.println(fileName);


		try {
			FileReader fileReader = new FileReader(fileName);
			BufferedReader leitura = new BufferedReader(fileReader);

			String linha =  null;
			while ((linha = leitura.readLine()) != null){
					System.out.println(linha);
				}
			fileReader.close();
			leitura.close();

			} catch (FileNotFoundException e) {
				System.out.println("[ERRO] O arquivo não existe!!!");
				e.printStackTrace();
			} catch (IOException e){
				System.out.println("[ERRO] erro ao fechar o reader");
			}

	}


}
