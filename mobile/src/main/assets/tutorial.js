@import "heading.css";
@import "paragraph.css";

/* @import rules must precede all others */

/* applies to everything */
* { font-family: "Arial Black", Gadget, sans-serif;}

/* applies to all under divs */

div * { font-family: "Comic Sans MS", cursive, sans-serif; }


/* for class */
.sitelink { font-family: Georgia, serif; }

/* for id = */
#tonyquote{
  font-family: "Lucida Sans Unicode", "Lucida Grande", sans-serif;
  color: black;
}

p.sitelink {
  font-family: "Palatino Linotype", "Book Antiqua", Palatino, serif;
  color: black;
}

span#tonyname {
  font-family: "Times New Roman", Times, serif;
  color: blue;
}

#tutorials ol li {
  color: purple;
}

#tutorials ul li {
  color: green;
}

h3 + p{
  font-style: italic;
}

h3 + p > a {
  color: red;
}

p[class] {
  background: gray;
}

p[id] {
  background: yellow;
}

*[alt~="nintendo"] {background: orange;}
