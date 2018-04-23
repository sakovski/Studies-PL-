using System;
using System.Collections.Generic;
using System.Text;

namespace Geometric
{
    public class Square : IGeometricFigure
    {
        public double A { get; set; }

        public Square(double a)
        {
            if(a <= 0)
                throw new ArgumentOutOfRangeException("Sides length less than zero");
            else
                A = a;
        }

        public double countCircuit()
        {
            return 4 * A;
        }

        public double countSurface()
        {
            return A * A;
        }

        public override string ToString()
        {
            return "Square with a = " + A;
        }

    }
}
