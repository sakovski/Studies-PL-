using System;
using System.Collections.Generic;
using System.Text;

namespace Geometric
{
    public class GeometricFiguresAnalyzer
    {
        private IGeometricFigure figure1;
        private IGeometricFigure figure2;

        public GeometricFiguresAnalyzer(IGeometricFigure f1, IGeometricFigure f2)
        {
            figure1 = f1;
            figure2 = f2;
        }

        public int compareCiruits()
        {
            double f1Circuit = figure1.countCircuit();
            double f2Circuit = figure2.countCircuit();
            if(f1Circuit > f2Circuit)
                return 1;
            else if(f1Circuit < f2Circuit)
                return -1;
            else
                return 0;
        }

        public int compareSurfaces()
        {
            double f1Surface = figure1.countSurface();
            double f2Surface = figure2.countSurface();
            if (f1Surface > f2Surface)
                return 1;
            else if (f1Surface < f2Surface)
                return -1;
            else
                return 0;
        }
    }
}
