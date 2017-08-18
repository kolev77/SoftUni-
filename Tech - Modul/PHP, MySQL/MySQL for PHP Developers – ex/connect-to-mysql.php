<?php
$hostname = 'localhost';
$username = 'root';
$password = '';
$dbname = 'exercise_blog';

$mysqli = new mysqli ($hostname, $username, $password, $dbname);

if ($mysqli->connect_errno){
    die('Error!');
}

$mysqli->set_charset('utf8');
$query = "SELECT * FROM users";
$result = $mysqli->query($query);

if (!$result){
    die('Error! Failed to proceed query');
}

if ($result->num_rows > 0){
    while ($row = $result->fetch_assoc()){
        echo "Id: ".$row['id']."<br>"
            ."Username: ".$row['username']."<br>"
            ."Full name: ".$row['fullname']."<br>";
    }
}
else
{
    echo "0 results";
}

$query = "SELECT * FROM posts";
$result = $mysqli->query($query);

if (!$result){
    die('Error! Failed to proceed query');
}

if ($result->num_rows > 0){
    while ($row = $result->fetch_assoc()) {
        echo "Id: ".$row['post_id']."<br>"
            ."Title: " . $row['title']."<br>"
            ."Date: " .$row['date']."<br>";
    }
}
else{
    echo "0 results";
}

$query = $mysqli->prepare(
    "INSERT INTO users(username, password, fullname)
    VALUES (?, ?, ?)"
);

$username = "Greta";
$password = md5("IchLiebeWurtschen");
$fullname = "Greta Berghoffen";

$query->bind_param("sss", $username, $password, $fullname);

$query->execute();

if ($query->affected_rows == 1){
    echo "User succesfully created!"."<br>";
}
else{
    echo "Inserting user failed!"."<br>";
}
