/*
 */
package br.com.lhmecatronica.util;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.math.MathContext;
import java.nio.channels.FileChannel;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.text.DecimalFormat;
import java.text.Normalizer;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class Biblioteca {

    public static String repete(String string, int quantidade) {
	StringBuffer retorno = new StringBuffer();
	for (int j = 0; j < quantidade; j++) {
	    retorno.append(string);
	}
	return retorno.toString();
    }

    public static String removeAcentos(String str) {  
        CharSequence cs = new StringBuilder(str == null ? "" : str);  
        return Normalizer.normalize(cs, Normalizer.Form.NFKD).replaceAll("\\p{InCombiningDiacriticalMarks}+", "");  
    }  
    
    public static boolean validaCpfCnpj(String s_aux) {
	if (s_aux.length() == 11) {
	    int d1, d2;
	    int digito1, digito2, resto;
	    int digitoCPF;
	    String nDigResult;
	    d1 = d2 = 0;
	    digito1 = digito2 = resto = 0;
	    for (int n_Count = 1; n_Count < s_aux.length() - 1; n_Count++) {
		digitoCPF = Integer.valueOf(s_aux.substring(n_Count - 1, n_Count)).intValue();
		d1 = d1 + (11 - n_Count) * digitoCPF;
		d2 = d2 + (12 - n_Count) * digitoCPF;
	    }

	    resto = (d1 % 11);
	    if (resto < 2) {
		digito1 = 0;
	    } else {
		digito1 = 11 - resto;
	    }
	    d2 += 2 * digito1;
	    resto = (d2 % 11);
	    if (resto < 2) {
		digito2 = 0;
	    } else {
		digito2 = 11 - resto;
	    }
	    String nDigVerific = s_aux.substring(s_aux.length() - 2, s_aux.length());
	    nDigResult = String.valueOf(digito1) + String.valueOf(digito2);
	    return nDigVerific.equals(nDigResult);
	} else if (s_aux.length() == 14) {
	    int soma = 0, dig;
	    String cnpj_calc = s_aux.substring(0, 12);
	    char[] chr_cnpj = s_aux.toCharArray();

	    for (int i = 0; i < 4; i++) {
		if (chr_cnpj[i] - 48 >= 0 && chr_cnpj[i] - 48 <= 9) {
		    soma += (chr_cnpj[i] - 48) * (6 - (i + 1));
		}
	    }
	    for (int i = 0; i < 8; i++) {
		if (chr_cnpj[i + 4] - 48 >= 0 && chr_cnpj[i + 4] - 48 <= 9) {
		    soma += (chr_cnpj[i + 4] - 48) * (10 - (i + 1));
		}
	    }
	    dig = 11 - (soma % 11);
	    cnpj_calc += (dig == 10 || dig == 11) ? "0" : Integer.toString(dig);
	    soma = 0;
	    for (int i = 0; i < 5; i++) {
		if (chr_cnpj[i] - 48 >= 0 && chr_cnpj[i] - 48 <= 9) {
		    soma += (chr_cnpj[i] - 48) * (7 - (i + 1));
		}
	    }
	    for (int i = 0; i < 8; i++) {
		if (chr_cnpj[i + 5] - 48 >= 0 && chr_cnpj[i + 5] - 48 <= 9) {
		    soma += (chr_cnpj[i + 5] - 48) * (10 - (i + 1));
		}
	    }
	    dig = 11 - (soma % 11);
	    cnpj_calc += (dig == 10 || dig == 11) ? "0" : Integer.toString(dig);
	    return s_aux.equals(cnpj_calc);
	} else {
	    return false;
	}
    }

    public static String md5String(String text) throws NoSuchAlgorithmException, UnsupportedEncodingException {
	MessageDigest md;
	md = MessageDigest.getInstance("MD5");
	byte[] md5hash = new byte[32];
	md.update(text.getBytes("iso-8859-1"), 0, text.length());
	md5hash = md.digest();
	return convertToHex(md5hash);
    }

    private static String convertToHex(byte[] data) {
	StringBuffer buf = new StringBuffer();
	for (int i = 0; i < data.length; i++) {
	    int halfbyte = (data[i] >>> 4) & 0x0F;
	    int two_halfs = 0;
	    do {
		if ((0 <= halfbyte) && (halfbyte <= 9)) {
		    buf.append((char) ('0' + halfbyte));
		} else {
		    buf.append((char) ('a' + (halfbyte - 10)));
		}
		halfbyte = data[i] & 0x0F;
	    } while (two_halfs++ < 1);
	}
	return buf.toString();
    }

    public static String md5File(String arquivo) throws NoSuchAlgorithmException, FileNotFoundException {
	MessageDigest digest = MessageDigest.getInstance("MD5");
	File f = new File(arquivo);
	InputStream is = new FileInputStream(f);
	byte[] buffer = new byte[8192];
	int read = 0;
	try {
	    while ((read = is.read(buffer)) > 0) {
		digest.update(buffer, 0, read);
	    }
	    byte[] md5sum = digest.digest();
	    BigInteger bigInt = new BigInteger(1, md5sum);
	    String output = bigInt.toString(16);
	    return output.toUpperCase();
	} catch (IOException e) {
	    throw new RuntimeException("Impossível processar o arquivo.", e);
	} finally {
	    try {
		is.close();
	    } catch (IOException e) {
	    }
	}
    }

    public static void removeLineFromFile(String file, String lineToRemove) {
	try {
	    File inFile = new File(file);
	    if (!inFile.isFile()) {
		System.out.println("Arquivo não localizado!");
		return;
	    }
	    // Construct the new file that will later be renamed to the original
	    // filename.
	    File tempFile = new File(inFile.getAbsolutePath() + ".tmp2");
	    BufferedReader br = new BufferedReader(new FileReader(file));
	    PrintWriter pw = new PrintWriter(new FileWriter(tempFile));
	    String line = null;
	    // Read from the original file and write to the new
	    // unless content matches data to be removed.
	    while ((line = br.readLine()) != null) {
		if (!line.equals(lineToRemove)) {
		    pw.println(line);
		    pw.flush();
		}
	    }
	    pw.close();
	    br.close();
	    // Delete the original file
	    if (!inFile.delete()) {
		System.out.println("Não foi possível apagar o arquivo");
		return;
	    }
	    // Rename the new file to the filename the original file had.
	    if (!tempFile.renameTo(inFile)) {
		System.out.println("Não foi possível renomear o arquivo!");
	    }
	} catch (FileNotFoundException ex) {
	    ex.printStackTrace();
	} catch (IOException ex) {
	    ex.printStackTrace();
	}
    }

    public static void addLineFromFile(String file, String lineToAdd) {
	try {
	    File inFile = new File(file);
	    if (!inFile.isFile()) {
		System.out.println("Arquivo não localizado!");
		return;
	    }
	    // Construct the new file that will later be renamed to the original
	    // filename.
	    File tempFile = new File(inFile.getAbsolutePath() + ".tmp");
	    BufferedReader br = new BufferedReader(new FileReader(file));
	    PrintWriter pw = new PrintWriter(new FileWriter(tempFile));
	    String line = null;
	    // Read from the original file and write to the new
	    // unless content matches data to be removed.
	    while ((line = br.readLine()) != null) {
		pw.println(line);
		pw.flush();
	    }
	    pw.println(lineToAdd);
	    pw.flush();
	    pw.close();
	    br.close();
	    // Delete the original file
	    if (!inFile.delete()) {
		System.out.println("Não foi possível apagar o arquivo");
		return;
	    }
	    // Rename the new file to the filename the original file had.
	    if (!tempFile.renameTo(inFile)) {
		System.out.println("Não foi possível renomear o arquivo!");
	    }
	} catch (FileNotFoundException ex) {
	    ex.printStackTrace();
	} catch (IOException ex) {
	    ex.printStackTrace();
	}

    }

    public static boolean isDataValida(String strData) {
	try {
	    if ((strData.length() != 10)) {
		return false;
	    }
	    Calendar dataValida = Calendar.getInstance();
	    dataValida.setLenient(false);
	    int dia = Integer.valueOf(strData.substring(0, 2));
	    int mes = Integer.valueOf(strData.substring(3, 5));
	    int ano = Integer.valueOf(strData.substring(6, 10));

	    dataValida.set(Calendar.DAY_OF_MONTH, dia);
	    dataValida.set(Calendar.MONTH, mes - 1);
	    dataValida.set(Calendar.YEAR, ano);

	    dataValida.getTime();

	    return true;
	} catch (Exception e) {
	    return false;
	}
    }

    public static BigDecimal formataToBigDecimal(String valor) {
	Double num = Double.valueOf(valor);
	BigDecimal bi = BigDecimal.valueOf(num);
	return bi;
    }

    public static String formatoDecimal(String tipo, String valor) {

	String mascara = "0.";
	if (tipo.equals("Q")) {
	    for (int i = 0; i < 0; i++) {
		mascara += "0";
	    }
	} else if (tipo.equals("V")) {
	    for (int i = 0; i < 2; i++) {
		mascara += "0";
	    }
	}
	DecimalFormat formato = new DecimalFormat(mascara);
	return formato.format(valor);
    }

    public static void copy(File origem, File destino, boolean overwrite) throws IOException {
	if (destino.exists() && !overwrite) {
	    System.err.println(destino.getName() + " já existe, ignorando...");
	    return;
	}
	FileInputStream fisOrigem = new FileInputStream(origem);
	FileOutputStream fisDestino = new FileOutputStream(destino);
	FileChannel fcOrigem = fisOrigem.getChannel();
	FileChannel fcDestino = fisDestino.getChannel();
	fcOrigem.transferTo(0, fcOrigem.size(), fcDestino);
	fisOrigem.close();
	fisDestino.close();
    }

    public static String primeiraMaiuscula(String texto) {
	return Character.toUpperCase(texto.charAt(0)) + texto.substring(1);
    }

    public static String formataData(Date dataFormatar) {
	SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
	return format.format(dataFormatar);
    }

    public static String formataHora(Date dataFormatar) {
	SimpleDateFormat format = new SimpleDateFormat("HH:mm:ss");
	return format.format(dataFormatar);
    }

    public static Date stringToDate(String texto) throws Exception {
	SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
	return format.parse(texto);
    }

    public static Date horaToDate(String hora) throws Exception {
	SimpleDateFormat format = new SimpleDateFormat("HH:mm:ss");
	return format.parse(hora);
    }

    public static BigDecimal multiplica(String valor1, String valor2) {
	BigDecimal resultado = new BigDecimal(valor1).multiply(new BigDecimal(valor2), MathContext.DECIMAL64);
	// resultado = resultado.setScale(Constantes.DECIMAIS_VALOR,
	// RoundingMode.DOWN);
	return resultado;
    }

     public static BigDecimal divide(String valor1, String valor2) {
	 BigDecimal resultado = new BigDecimal(valor1).divide(new BigDecimal(valor2), MathContext.DECIMAL64);
     return resultado;
     }
    
    public static BigDecimal subtrai(String valor1, String valor2) {
	BigDecimal resultado = new BigDecimal(valor1).subtract(new BigDecimal(valor2), MathContext.DECIMAL64);
	return resultado;
    }

    public static BigDecimal soma(String valor1, String valor2) {
	if (valor1 == "") {
	    valor1 = "0";
	}
	if (valor2 == "") {
	    valor2 = "0";
	}

	BigDecimal resultado = new BigDecimal(valor1.replace(",", ".")).add(new BigDecimal(valor2.replace(",", ".")), MathContext.DECIMAL64);
	return resultado;
    }

    public static String hashRegistro(Object bean) throws Exception {
	Field fields[] = bean.getClass().getDeclaredFields();
	DecimalFormat decimalFormat = new DecimalFormat("0.000000");
	String hash = "";
	Method metodo = bean.getClass().getDeclaredMethod("setLogss", String.class);
	metodo.invoke(bean, "0");
	for (Field f : fields) {
	    if (!f.getName().equals("serialVersionUID")) {
		metodo = bean.getClass().getDeclaredMethod("get" + primeiraMaiuscula(f.getName()));
		if (f.getType() == Integer.class || f.getType() == String.class || f.getType() == BigDecimal.class
			|| f.getType() == Double.class) {
		    if (f.getType() == BigDecimal.class) {
			hash += decimalFormat.format(metodo.invoke(bean));
		    } else {
			hash += metodo.invoke(bean);
		    }
		} else if (f.getType() == Date.class) {
		    Date pData = (Date) metodo.invoke(bean);
		    if (pData != null) {
			hash += formataData(pData);
		    } else {
			hash += "null";
		    }
		} else if (f.getType() != List.class) {
		    Object obj = metodo.invoke(bean);
		    if (obj != null) {
			metodo = obj.getClass().getDeclaredMethod("getId");
			hash += metodo.invoke(obj);
		    } else {
			hash += "null";
		    }
		}
	    }
	}
	return md5String(hash);
    }

    public static Integer modulo11(String codigo) {
	int total = 0;
	int peso = 2;

	for (int i = 0; i < codigo.length(); i++) {
	    total += (codigo.charAt((codigo.length() - 1) - i) - '0') * peso;
	    peso++;
	    if (peso == 10) {
		peso = 2;
	    }
	}
	int resto = total % 11;
	return (resto == 0 || resto == 1) ? 0 : (11 - resto);
    }

    public static BigDecimal atualizaTotal(String atual, String qtd, String preco, String acao) {
	BigDecimal b = multiplica(qtd, preco);
	BigDecimal total = new BigDecimal(atual.replace(",", "."));
	switch (acao) {
	case "add":
	    total = total.add(b);
	    break;
	case "sub":
	    total = total.subtract(b);
	    break;
	}
	//String unitario = formatoDecimal("V", Double.valueOf(total.toString()));
	return total;
    }

    public static Double trocarVirgulaPorPonto(String valor) {
	return Double.valueOf(valor.replace(".", "").replace(",", "."));
    }

}
