<?php
$mysqli = new mysqli ('localhost', 'root', '', 'new_blog');
$mysqli->set_charset('utf8');
if ($mysqli->connect_errno) die('Cannot connect to MySQL');

$result = $mysqli->query('SELECT * FROM posts ORDER BY date');
if (!$result) die('Cannot read `posts` table from MySQL');

echo "<table>\n";
echo "<tr>".
        "<th style='background: lightgrey'>Title</th>".
        "<th style='background: lightgrey'>Content</th>".
        "<th style='background: lightgrey'>Date</th>".
    "</tr>\n";


while ($row = $result->fetch_assoc())
{
    $title = htmlspecialchars($row['title']);
    $body = htmlspecialchars($row['content']);
    $date = (new DateTime($row['date']))->format('d.m.Y');
    echo "<tr>" .
            "<td style='background: lightgrey'>$title</td>" .
            "<td style='background: lightgrey'>$body</td>" .
            "<td style='background: lightgrey'>$date</td>" .
          "</tr>\n";
    
}
echo "</table>";