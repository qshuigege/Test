package test;

public class TT {/*
	public static void main(String[] args) {
		BasicCookieStore cookieStore = new BasicCookieStore();
		HttpPost post = null;
		try {
			String url = "https://account.xiaomi.com/pass/serviceLoginAuth2";
			CloseableHttpClient httpclient = HttpClients.custom()
					.setDefaultCookieStore(cookieStore).build();
			post = new HttpPost(url);
			post.setHeader(
					"User-Agent",
					"mozilla/5.0 (linux; u; android 4.2.2; zh-cn; mi-one c1 build/imm76d) uc applewebkit/534.31 (khtml, like gecko) mobile safari/534.31");
			List<NameValuePair> nvps = new ArrayList<NameValuePair>();
			nvps.add(new BasicNameValuePair("user", "XXXXX"));// xxx表示小米账号名
			nvps.add(new BasicNameValuePair("pwd", "xxxx")); // xxx表示账号密码
			nvps.add(new BasicNameValuePair("callback",
					"https://account.xiaomi.com"));
			nvps.add(new BasicNameValuePair("sid", "passport"));
			nvps.add(new BasicNameValuePair("display", "mobile"));
			nvps.add(new BasicNameValuePair("qs", "%3Fsid%3Dpassport"));
			nvps.add(new BasicNameValuePair("_sign",
					"KKkRvCpZoDC+gLdeyOsdMhwV0Xg="));
			post.setEntity(new UrlEncodedFormEntity(nvps, Consts.UTF_8));
			HttpResponse response = httpclient.execute(post);
			String getvalue = EntityUtils.toString(response.getEntity());
			System.out.println(getvalue);
			int first = getvalue.indexOf("=");
			int last = getvalue.indexOf(">");
			String getURL = getvalue.substring(first + 2, last - 1);
			System.out.println(getURL);
			HttpGet httpGet = new HttpGet(getURL);
			httpGet.setHeader(
					"User-Agent",
					"mozilla/5.0 (linux; u; android 4.2.2; zh-cn; mi-one c1 build/imm76d) uc applewebkit/534.31 (khtml, like gecko) mobile safari/534.31");
			HttpResponse response2 = httpclient.execute(httpGet);
			String reallyURL = EntityUtils.toString(response2.getEntity());
			System.out.println(reallyURL);
			HttpGet httpGet2 = new HttpGet(
					"http://m.xiaomi.com/home/index.html");
			httpGet2.setHeader(
					"User-Agent",
					"mozilla/5.0 (linux; u; android 4.2.2; zh-cn; mi-one c1 build/imm76d) uc applewebkit/534.31 (khtml, like gecko) mobile safari/534.31");
			HttpResponse response3 = httpclient.execute(httpGet2);
			List<Cookie> cookies = cookieStore.getCookies();
			if (cookies.isEmpty()) {
				System.out.println("None");
			} else {
				for (int i = 0; i < cookies.size(); i++) {
					System.out.println("- " + cookies.get(i).toString());
				}
			}
			System.out.println(EntityUtils.toString(response3.getEntity()));
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			post.abort();
		}
	}
*/}