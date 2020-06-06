//package challenge;
//
//import java.io.BufferedReader;
//import java.io.FileReader;
//import java.io.IOException;
//import java.util.ArrayList;
//import java.util.List;
//import java.util.Map;
//
//public class Main {
//
//	public static void main(String[] args) {
//		System.out.println(q1());
//	}
//
//	static List<String> listaNacionalidades = new ArrayList<>();
//
//	public static void importCSV(){
//
//		String path = "/home/alice/codenation/java-3/src/main/resources/data.csv";
//		try (BufferedReader br = new BufferedReader(new FileReader(path))) {
//
//			String line = br.readLine();
//			line = br.readLine();
//			while (line != null) {
//				String[] campo = line.split(",");;
//				if(campo[14] != "" && !listaNacionalidades.contains(campo[14]))
//					listaNacionalidades.add(campo[14]);
//
//				line = br.readLine();
//			}
//		}catch (IOException e){
//			e.printStackTrace();
//		}
//	}
//
//	// Quantas nacionalidades (coluna nationality) diferentes existem no arquivo?
//	public static int q1() {
//		importCSV();
//		return listaNacionalidades.size();
//	}
//
//	// Quantos clubes (coluna club) diferentes existem no arquivo?
//	// Obs: Existem jogadores sem clube.
//	public int q2() {
//		return 0;
//	}
//
//	// Liste o nome completo (coluna full_name) dos 20 primeiros jogadores.
//	public List<String> q3() {
//		return null;
//	}
//
//	// Quem são os top 10 jogadores que possuem as maiores cláusulas de rescisão?
//	// (utilize as colunas full_name e eur_release_clause)
//	public List<String> q4() {
//		return null;
//	}
//
//	// Quem são os 10 jogadores mais velhos (use como critério de desempate o campo eur_wage)?
//	// (utilize as colunas full_name e birth_date)
//	public List<String> q5() {
//		return null;
//	}
//
//	// Conte quantos jogadores existem por idade. Para isso, construa um mapa onde as chaves são as idades e os valores a contagem.
//	// (utilize a coluna age)
//	public Map<Integer, Integer> q6() {
//		return null;
//	}
//
//
//}
//
