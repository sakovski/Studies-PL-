using System;
using System.Collections.Generic;
using System.Text;

namespace Geometric
{
    public interface IGeometricFigure
    {
        double countCircuit();
        double countSurface();
    }
}
