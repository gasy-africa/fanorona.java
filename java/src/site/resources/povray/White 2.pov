// Persistence of Vision Ray Tracer Scene Description File
// File: Board.pov
// Vers: 3
// Desc: Fanorona board covered with white pieces
// Date: 15 June 1997
// Auth: David Eppstein, Dept. Inf. & Comp. Sci., UC Irvine

// ==== Standard POV-Ray Includes ====
#include "colors.inc"	// Standard Color definitions
#include "textures.inc"	// Standard Texture definitions
#include "woods.inc"

// set viewer's position in the scene
camera
{
  location  <0.0, 20.0, -10.0> // position of camera <X Y Z>
  direction 3.5*z            // which way are we looking <X Y Z> & zoom
  up        y                // which way is +up <X Y Z>
  right     400/225*x 		 // which way is +right <X Y Z> and aspect ratio
  look_at   <0.0, 0.0,  0.0> // point center of view at this point <X Y Z>
}

// light sources
light_source
{
  0*x // light's position (translated below)
  color red 1  green 1 blue 1  // light's color
  translate <-7, 40, 10>
}
light_source
{
  0*x // light's position (translated below)
  color red 0.5  green 0.5 blue 0.5  // light's color
  translate <-10, 0, -40>
}

// game board
box
{
	<-5, 0, -3>  // one corner position <X1 Y1 Z1>
	<5,  1,  3>  // other corner position <X2 Y2 Z2>
	texture { T_Wood7 }
}
