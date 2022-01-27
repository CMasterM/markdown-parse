import static org.junit.Assert.*;
import org.junit.*;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.*;


public class MarkdownParseTest {
    @Test
    public void addition() {
        assertEquals(2, 1 + 1);
    }
    @Test
    public void testFile() throws IOException{
        ArrayList<String> rightLinks = new ArrayList<>(2);
        rightLinks.add("https://something.com");
        rightLinks.add("some-page.html");
        ArrayList<String> links = MarkdownParse.getLinks(Files.readString(Path.of("test-file.md")));
        assertEquals(rightLinks, links);
    }
    @Test
    public void testBackslashEscape()throws IOException{
        ArrayList<String> links = MarkdownParse.getLinks(Files.readString(Path.of("test-backslash-escapes.md")));
        assertEquals(List.of("/close_bracket", "/single_)bracket", "/double_\\","/triple_\\)bracket", "/quad_\\\\", "/open_(paren"), links);
    }

}