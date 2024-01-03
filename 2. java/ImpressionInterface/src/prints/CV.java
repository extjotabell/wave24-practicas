package prints;

import java.util.ArrayList;
import java.util.List;

import prints.interfaces.AbstractPrint;

public class CV extends AbstractPrint {
    private List<String> attributes = new ArrayList<>();

    public CV(String author) {
        super(author);
    }
    public CV(String author, List<String> attributes) {
        super(author);
        this.attributes = attributes;
    }

    public String addAttribute(String attribute) {
        attributes.add(attribute);

        return "You have added " + attribute + " to your CV.";
    }
    public String removeAttribute(String attribute) {
        attributes.remove(attribute);

        return "You have removed " + attribute + " from your CV.";
    }

    @Override
    public String print() {
        var attributesString = String.join("\n", attributes);

        return "Curriculum Vitae\n\nAuthor: " + this.getAuthor() + "\n\nAttributes: " + attributesString;
    }

    public List<String> getAttributes() {
        return attributes;
    }
    public void setAttributes(List<String> attributes) {
        this.attributes = attributes;
    }
}
