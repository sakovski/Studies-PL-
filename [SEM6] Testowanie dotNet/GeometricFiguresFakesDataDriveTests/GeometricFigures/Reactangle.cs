using System;
using System.Collections.Generic;
using System.Text;

namespace GeometricFigures
{
    class Reactangle : IGeometricFigure
    {
        public double A { get; set; }
        public double B { get; set; }

        public Reactangle(int a, int b)
        {
            A = a;
            B = b;
        }

        public double countCircuit()
        {
            return 2 * A + 2 * B;
        }

        public double countSurface()
        {
            return A * B;
        }
    }
}
