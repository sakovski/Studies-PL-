using System;
using System.Collections.Generic;
using System.Text;

namespace Geometric
{
    public class Rectangle : IGeometricFigure
    {
        public double A { get; set; }
        public double B { get; set; }

        public Rectangle(double a, double b)
        {
            if (a <= 0 || b <= 0)
                throw new ArgumentOutOfRangeException("Sides length less than zero");
            else
            {
                A = a;
                B = b;
            }
            
        }

        public double countCircuit()
        {
            return 2 * A + 2 * B;
        }

        public double countSurface()
        {
            return A * B;
        }

        public override string ToString()
        {
            return "Rectangle with a = " + A + "; b = " + B;
        }
    }
}
