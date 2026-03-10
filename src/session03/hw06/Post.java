package session03.hw06;

import java.util.List;

class Post {
    private List<String> tags;

    public Post(List<String> tags) {
        this.tags = tags;
    }

    public List<String> getTags() {
        return tags;
    }
}
