using System;

namespace Geometric
{
    public class Triangle : IGeometricFigure
    {
        public double A { get; set; }
        public double B { get; set; }
        public double C { get; set; }

        public Triangle(double a, double b, double c)
        {
            if (a <= 0 || b <= 0 || c <= 0)
                throw new ArgumentOutOfRangeException("Sides length less than zero");

            if (a + b > c && a + c > b && b + c > a)
            {
                A = a;
                B = b;
                C = c;
            }
            else
                throw new ArgumentOutOfRangeException("Sum of two sides length cant be less than third side length");         
        }

        public double countCircuit()
        {
            return A + B + C;
        }

        public double countSurface()
        {
            return Math.Sqrt((A + B + C) * (A + B - C) * (A - B + C) * (-A + B + C)) / 4; //Heron's formula
        }

        public bool isRight() //Prostokatny
        {
            return ((A * A + B * B == C * C) || (A * A + C * C == B * B) || (B * B + C * C == A * A));
        }

        public bool isEquilateral() //Rownoboczny
        {
            return (A == B) && (B == C);
        }

        public bool isIsosceles() //Rownoramienny
        {
            return ((A == B) || (B == C) || (A == C));
        }

        public override string ToString()
        {
            return "Triangle with a = " + A + "; b = " + B + "; c = " + C;
        }
    }
}