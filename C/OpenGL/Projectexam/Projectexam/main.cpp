#include<Windows.h>
#include <gl/glut.h>
#include <gl/GL.h>
#include <gl/GLU.h>



void MyDisplay() {
	glClear(GL_COLOR_BUFFER_BIT);

	glColor3f(1.0, 0.0, 1.0);
	glutWireTorus(1, 3, 15, 50);

	glFlush();

}


int main(int argc, char** argv)
{
	glutInit(&argc, argv);
	glutInitDisplayMode(GLUT_SINGLE | GLUT_RGB);
	glutCreateWindow("¿”º∫»Ø-201611587");
	glutInitWindowPosition(80, 80);
	glutInitWindowSize(1000, 1000);
	glMatrixMode(GL_PROJECTION);
	glLoadIdentity();
	glOrtho(-1.0, 1.0, -1.0, 1.0, -1.0, 1.0);

	glutDisplayFunc(MyDisplay);
	glutMainLoop();

	return 0;
}