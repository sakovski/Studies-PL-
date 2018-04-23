using System;
using System.Collections.Generic;
using System.Text;

namespace GeometricFigures
{
    class Square : IGeometricFigure
    {
        public double A { get; set; }

        public Square(int a)
        {
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
    }
}
