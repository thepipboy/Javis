import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class WebCrawler {
    private static final int MAX_DEPTH = 2;
    private static final String URL_REGEX = "https?://[\\w-]+(?:\\.[\\w-]+)+[\\w.,@?^=%&:/~+#-]*[\\w@?^=%&/~+#-]";
    private static final Pattern URL_PATTERN = Pattern.compile(URL_REGEX);
    private static final Set<String> visitedUrls = new HashSet<>();

    public static void main(String[] args) {
        String startUrl = "https://example.com";
        crawl(startUrl, 0);
    }

    private static void crawl(String url, int depth) {
        if (depth > MAX_DEPTH || visitedUrls.contains(url)) {
            return;
        }

        visitedUrls.add(url);
        System.out.println("Crawling: " + url + " (Depth: " + depth + ")");

        try {
            String content = fetchContent(url);
            List<String> links = extractLinks(content);

            for (String link : links) {
                // Simulate "self-duplication" by creating a new crawler instance
                WebCrawler newCrawler = new WebCrawler();
                newCrawler.crawl(link, depth + 1);
            }
        } catch (Exception e) {
            System.err.println("Error crawling " + url + ": " + e.getMessage());
        }
    }

    private static String fetchContent(String url) throws Exception {
        StringBuilder content = new StringBuilder();
        URL urlObj = new URL(url);
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(urlObj.openStream()))) {
            String line;
            while ((line = reader.readLine()) != null) {
                content.append(line);
            }
        }
        return content.toString();
    }

    private static List<String> extractLinks(String content) {
        List<String> links = new ArrayList<>();
        Matcher matcher = URL_PATTERN.matcher(content);
        while (matcher.find()) {
            links.add(matcher.group());
        }
        return links;
    }
}