using System;
using System.Collections.Generic;
using System.Text;

namespace Geometric
{
    public class Circle : IGeometricFigure
    {
        public double R { get; set; }

        public Circle(double r)
        {
            if(r > 0)
                R = r;
            else
                throw new ArgumentOutOfRangeException("Radius less than zero");
        }

        public double countCircuit()
        {
            return 2 * Math.PI * R;
        }

        public double countSurface()
        {
            return Math.PI * R * R;
        }

        public override string ToString()
        {
            return "Circle with r = " + R;
        }
    }
}
