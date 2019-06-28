import facebook4j.Comment;
import facebook4j.Facebook;
import facebook4j.FacebookException;
import facebook4j.FacebookFactory;
import facebook4j.PagableList;
import facebook4j.Post;
import facebook4j.Reading;
import facebook4j.ResponseList;
import facebook4j.auth.AccessToken;
//Sutrimo 16.01.53.0183
public class PostsFromPageExtractor {


public static void main(String[] args) throws FacebookException {

 // Generate facebook instance.
Facebook facebook = new FacebookFactory().getInstance();
// Use default values for oauth app id.
facebook.setOAuthAppId("366RAHASIA67498", "1e85d37cdRAHASIA04f27802006");
// Get an access token from: 
// https://developers.facebook.com/tools/explorer
// Copy and paste it below.
String accessTokenString = "EAAFNxPvUzZBoBADPGdPoQwOMix07jhF4rnxORAHASIAiEE9kiXkTeFXDRZAAS78hje7VRRNb1jVAAKWaSAbwdplZBXgVCEnZArYVLCH4xcaX0gvSZC3K0INwueEa2PkMzOO8qhzNY9ZBQlvauw6ZAKziSakFsrcx4ZBj1BBc8m3OzfTgJ5xA3zZAi9tWzwZDZD";
AccessToken at = new AccessToken(accessTokenString);
// Set access token.
facebook.setOAuthAccessToken(at);

 // We're done.
// Access group feeds.
// You can get the group ID from:
// https://developers.facebook.com/tools/explorer

 // Set limit to 25 feeds.

 ResponseList<Post> feeds = facebook.getFeed("1325RAHASIA93907",
new Reading().limit(25));

 // For all 25 feeds...
for (int i = 0; i < feeds.size(); i++) {
// Get post.
Post post = feeds.get(i);
// Get (string) message.
String message = post.getMessage();
// Print out the message.
System.out.println(message);
PagableList comments = post.getComments();
String date = post.getCreatedTime().toString();
// String name = post.getFrom().getName();
String id = post.getId();
System.out.println(date);
System.out.println(id);
}
 }	
}
