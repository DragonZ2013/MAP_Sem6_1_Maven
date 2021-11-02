public class Message {
    private String file;
    private String text;

    public Message(String file, String text) {
        this.file = file;
        this.text = text;
    }

    public String getFile() {
        return file;
    }

    public void setFile(String file) {
        this.file = file;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    @Override
    public String toString() {
        return "Message{" +
                "file='" + file + '\'' +
                ", text='" + text + '\'' +
                '}';
    }
}
