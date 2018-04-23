using System;

namespace GeometricFigures
{
    public class Triangle : IGeometricFigure
    {
        public double A { get; set; }
        public double B { get; set; }
        public double C { get; set; }

        public Triangle(double a, double b, double c)
        {
            A = a;
            B = b;
            C = c;
        }

        public double countCircuit()
        {
            return A + B + C;
        }

        public double countSurface()
        {
            return Math.Sqrt((A + B + C) * (A + B - C) * (A - B + C) * (-A + B + C)) / 4; //Heron's formula
        }

        public bool isRight()
        {
            return ((A * A + B * B == C * C) || (A * A + C * C == B * B) || (B * B + C * C == A * A));
        }

        public bool isEquilateral()
        {
            return (A == B) && (B == C);
        }

        public bool isIsosceles()
        {
            return ((A == B) || (B == C) || (A == C));
        }
    }
}
