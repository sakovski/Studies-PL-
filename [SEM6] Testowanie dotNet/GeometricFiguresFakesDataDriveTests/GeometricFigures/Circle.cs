using System;
using System.Collections.Generic;
using System.Text;

namespace GeometricFigures
{
    class Circle : IGeometricFigure
    {
        public double R { get; set; }

        public Circle(double r)
        {
            R = r;
        }

        public double countCircuit()
        {
            return 2 * Math.PI * R;
        }

        public double countSurface()
        {
            return Math.PI * R * R;
        }
    }
}
