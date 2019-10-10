package arlyn.playground.base;

public class JsonResponseCleaner {
    public String JsonCleaning(String response){
        StringBuffer buf = new StringBuffer(response);

        //remove prefix text String(...)
        int start = 0;
        int end = buf.indexOf(" ");
        buf.replace(start, end+1, "");

        //remove double quote on the first character and the last
        buf.deleteCharAt(buf.length()-1);
        buf.deleteCharAt(buf.length()-1);
        buf.deleteCharAt(0);

        return buf.toString();
    }
}
