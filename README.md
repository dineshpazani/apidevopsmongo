# apidevopsmongo




private String getFileContent(String fileName) throws IOException {
		InputStream resource = null;
		InputStreamReader reader = null;
		BufferedReader bufferedReader = null;
		StringBuilder lines = new StringBuilder();
		try {
			resource = this.getClass().getResourceAsStream(fileName);
			reader = new InputStreamReader(resource);
			bufferedReader = new BufferedReader(reader);
			String str;
			while ((str = bufferedReader.readLine()) != null) {
				lines.append(str);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			resource.close();
			reader.close();
			bufferedReader.close();
		}
		return lines.toString();
	}
