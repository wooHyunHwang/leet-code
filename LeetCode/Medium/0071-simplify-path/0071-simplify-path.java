class Solution {
    public String simplifyPath(String path) {
        LinkedList<String> folder = new LinkedList<>();

        String[] req = path.split("/");

        for (int i = 0; i < req.length; ++i) {
            switch(req[i]) {
                case "":
                case ".": break;
                case "..": {
                    if(!folder.isEmpty()) folder.removeLast();
                    break;
                }
                default: {
                    folder.add(req[i]);
                }
            }
        }

        StringBuilder sb = new StringBuilder("/");

        for (int i = 0; i < folder.size(); ++i) {
            if(sb.length() != 1) sb.append("/");
            sb.append(folder.get(i));
        }

        return sb.toString();
    }
}