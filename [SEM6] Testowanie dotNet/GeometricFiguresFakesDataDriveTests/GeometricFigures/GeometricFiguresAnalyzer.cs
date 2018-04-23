using System;
using System.Collections.Generic;
using System.Text;

namespace GeometricFigures
{
    class GeometricFiguresAnalyzer
    {
        private IGeometricFigure figure1;
        private IGeometricFigure figure2;

        public GeometricFiguresAnalyzer(IGeometricFigure f1, IGeometricFigure f2)
        {
            figure1 = f1;
            figure2 = f2;
        }

        public bool compareCiruits()
        {
            return figure1.countCircuit() > figure2.countCircuit() ? true : false;
        }

        public bool compareSurfaces()
        {
            return figure1.countSurface() > figure2.countSurface() ? true : false;
        }

        public bool areTheSameType()
        {
            return figure1.GetType().Equals(figure2.GetType());
        }
    }
}
