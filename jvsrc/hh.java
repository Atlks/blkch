class hh {
    public static void main(String[] args) {
        System.out.println("jjjj222!"); 
    }
}



@ApiIgnore
//@ CrossOrigin
@RestController
class QueryData   {



    @RequestMapping(value = "/queryFrd" )
    public Object queryFrd(HttpServletRequest request) {

        Properties environment=Util.getPropObjFrmSprbt();
        MongoClient mongoClient = Util. getMongoClient(environment);


        MongoCollection<Document> collection = mongoClient.getDatabase(environment.getProperty("mongoconfig.dbName")).getCollection("user");
        FindIterable<Document> documents = collection.find();
        List li=new ArrayList();
        int i=0;
        for (Document document : documents) {
            i++;if(i>999)
                break;
            JSONObject jo=new JSONObject();
            jo.put("uname",document.get("username"));
            jo.put("_id",document.get("_id"));
            li.add(jo);
        }
        mongoClient.close();
        return li;

    }