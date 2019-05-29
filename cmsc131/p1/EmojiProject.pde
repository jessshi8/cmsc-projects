void setup() {
  size(500, 500);
  background(219, 243, 255);
}

void draw() {
  // Create face. 
  stroke(10);
  strokeWeight(5);
  fill(255, 246, 81);
  ellipse(250, 250, 300, 300);
  
  // Create eyes.
  strokeWeight(5);
  fill(250);
  ellipse(190, 225, 50, 70);
  ellipse(310, 225, 50, 70);
   
  // Create pupils.
  strokeWeight(5);
  fill(0);
  ellipse(200, 230, 25, 35);
  ellipse(300, 230, 25, 35);
  
  // Create facial hair.
  strokeWeight(10);
  fill(0);
  ellipse(235, 290, 22, 22);
  ellipse(265, 290, 22, 22);
  ellipse(210, 290, 18, 18);
  ellipse(290, 290, 18, 18);
  ellipse(190, 290, 10, 10);
  ellipse(310, 290, 10, 10);
  ellipse(175, 290, 8, 8);
  ellipse(325, 290, 8, 8);
  line(160, 290, 340, 290);
  
  strokeWeight(5);
  noFill();
  arc(250, 200, 200, 290, PI/3, (2.2*PI)/3);
}
