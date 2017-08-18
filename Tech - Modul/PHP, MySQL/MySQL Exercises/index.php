<?php
$hostname = 'localhost';// This is our database`s host name
$username = 'root'; // This is the username for our database
$password = '';// This is the password for our username
$dbname = 'blog'; // This is our database`s name

$mysqli = new mysqli($hostname,$username,$password,$dbname);

if ($mysqli->connect_errno){
    die ("Error! Failed to connect to MySQL");
}
$mysqli->set_charset("utf8");

$query = $mysqli->prepare(
        "INSERT INTO users (username,password,fullname ) VALUES (?, ?, ?)");
$username = "Greta";
$password = md5("IchLiebeWurtschen");
$fullname = "Greta Berghoffen";

$query->bind_param("sss",$username,$password,$fullname);

$query->execute();

if ($query->affected_rows == 1){
    echo "User successfully created!";
}
else{
    die("Inserting user failed");
}
/*$query = "SELECT * FROM posts";                           // Show posts
$result = $mysqli->query($query);
while ($row = $result->fetch_assoc()){
    echo "Id: " . $row['user_id'] . "<br>"
        . "Title: " . $row['title'] . "<br>"
        . "Content: " . $row['content'] . "<br>"
        . "Date: " . $row['date']. "<br>";
}*/

/*$query = "SELECT * FROM users";                         // Show users
$result = $mysqli->query($query);

if (!$result){
    die('Error! Failed to process query');
}
if ($result->num_rows >0){
    while ($row = $result->fetch_assoc()){
        echo "Id: " . htmlspecialchars($row['id']) . "<br>"
            ."Username: " . htmlspecialchars($row['username']) . "<br>"
            ."Full name: " . htmlspecialchars($row['fullname']) . "<br>";
    }
}
else{
    echo "0 results";
}*/
?>