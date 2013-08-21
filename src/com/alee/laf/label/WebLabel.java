/*
 * This file is part of WebLookAndFeel library.
 *
 * WebLookAndFeel library is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * WebLookAndFeel library is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with WebLookAndFeel library.  If not, see <http://www.gnu.org/licenses/>.
 */

package com.alee.laf.label;

import com.alee.extended.painter.Painter;
import com.alee.laf.WebLookAndFeel;
import com.alee.managers.language.LanguageManager;
import com.alee.managers.language.LanguageMethods;
import com.alee.managers.language.updaters.LanguageUpdater;
import com.alee.utils.ReflectUtils;
import com.alee.utils.SizeUtils;
import com.alee.utils.SwingUtils;
import com.alee.utils.swing.FontMethods;
import com.alee.utils.swing.SizeMethods;

import javax.swing.*;
import java.awt.*;

/**
 * User: mgarin Date: 26.07.11 Time: 13:16
 */

public class WebLabel extends JLabel implements LanguageMethods, FontMethods<WebLabel>, SizeMethods<WebLabel>
{
    public WebLabel ()
    {
        super ();
    }

    public WebLabel ( Insets margin )
    {
        super ();
        setMargin ( margin );
    }

    public WebLabel ( Icon image )
    {
        super ( image );
    }

    public WebLabel ( Icon image, Insets margin )
    {
        super ( image );
        setMargin ( margin );
    }

    public WebLabel ( int horizontalAlignment )
    {
        super ();
        setHorizontalAlignment ( horizontalAlignment );
    }

    public WebLabel ( int horizontalAlignment, Insets margin )
    {
        super ();
        setHorizontalAlignment ( horizontalAlignment );
        setMargin ( margin );
    }

    public WebLabel ( Icon image, int horizontalAlignment )
    {
        super ( image, horizontalAlignment );
    }

    public WebLabel ( Icon image, int horizontalAlignment, Insets margin )
    {
        super ( image, horizontalAlignment );
        setMargin ( margin );
    }

    public WebLabel ( String text )
    {
        super ( text );
    }

    public WebLabel ( String text, Insets margin )
    {
        super ( text );
        setMargin ( margin );
    }

    public WebLabel ( String text, int horizontalAlignment )
    {
        super ( text, horizontalAlignment );
    }

    public WebLabel ( String text, int horizontalAlignment, Insets margin )
    {
        super ( text, horizontalAlignment );
        setMargin ( margin );
    }

    public WebLabel ( String text, Icon icon )
    {
        super ( text, icon, LEADING );
    }

    public WebLabel ( String text, Icon icon, Insets margin )
    {
        super ( text, icon, LEADING );
        setMargin ( margin );
    }

    public WebLabel ( String text, Icon icon, int horizontalAlignment )
    {
        super ( text, icon, horizontalAlignment );
    }

    public WebLabel ( String text, Icon icon, int horizontalAlignment, Insets margin )
    {
        super ( text, icon, horizontalAlignment );
        setMargin ( margin );
    }

    public Insets getMargin ()
    {
        return getWebUI ().getMargin ();
    }

    public void setMargin ( Insets margin )
    {
        getWebUI ().setMargin ( margin );
    }

    public WebLabel setMargin ( int top, int left, int bottom, int right )
    {
        setMargin ( new Insets ( top, left, bottom, right ) );
        return this;
    }

    public WebLabel setMargin ( int spacing )
    {
        return setMargin ( spacing, spacing, spacing, spacing );
    }

    public Painter getPainter ()
    {
        return getWebUI ().getPainter ();
    }

    public WebLabel setPainter ( Painter painter )
    {
        getWebUI ().setPainter ( painter );
        return this;
    }

    public boolean isDrawShade ()
    {
        return getWebUI ().isDrawShade ();
    }

    public WebLabel setDrawShade ( boolean drawShade )
    {
        getWebUI ().setDrawShade ( drawShade );
        return this;
    }

    public Color getShadeColor ()
    {
        return getWebUI ().getShadeColor ();
    }

    public WebLabel setShadeColor ( Color shadeColor )
    {
        getWebUI ().setShadeColor ( shadeColor );
        return this;
    }

    public Float getTransparency ()
    {
        return getWebUI ().getTransparency ();
    }

    public WebLabel setTransparency ( Float transparency )
    {
        getWebUI ().setTransparency ( transparency );
        return this;
    }

    public WebLabelUI getWebUI ()
    {
        return ( WebLabelUI ) getUI ();
    }

    @Override
    public void updateUI ()
    {
        if ( getUI () == null || !( getUI () instanceof WebLabelUI ) )
        {
            try
            {
                setUI ( ( WebLabelUI ) ReflectUtils.createInstance ( WebLookAndFeel.labelUI ) );
            }
            catch ( Throwable e )
            {
                e.printStackTrace ();
                setUI ( new WebLabelUI () );
            }
        }
        else
        {
            setUI ( getUI () );
        }
    }

    /**
     * Language methods
     */

    /**
     * {@inheritDoc}
     */
    @Override
    public void setLanguage ( String key, Object... data )
    {
        LanguageManager.registerComponent ( this, key, data );
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void updateLanguage ( Object... data )
    {
        LanguageManager.updateComponent ( this, data );
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void updateLanguage ( String key, Object... data )
    {
        LanguageManager.updateComponent ( this, key, data );
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void removeLanguage ()
    {
        LanguageManager.unregisterComponent ( this );
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean isLanguageSet ()
    {
        return LanguageManager.isRegisteredComponent ( this );
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void setLanguageUpdater ( LanguageUpdater updater )
    {
        LanguageManager.registerLanguageUpdater ( this, updater );
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void removeLanguageUpdater ()
    {
        LanguageManager.unregisterLanguageUpdater ( this );
    }

    /**
     * Font methods
     */

    /**
     * {@inheritDoc}
     */
    @Override
    public WebLabel setPlainFont ()
    {
        return SwingUtils.setPlainFont ( this );
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public WebLabel setPlainFont ( boolean apply )
    {
        return SwingUtils.setPlainFont ( this, apply );
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean isPlainFont ()
    {
        return SwingUtils.isPlainFont ( this );
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public WebLabel setBoldFont ()
    {
        return SwingUtils.setBoldFont ( this );
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public WebLabel setBoldFont ( boolean apply )
    {
        return SwingUtils.setBoldFont ( this, apply );
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean isBoldFont ()
    {
        return SwingUtils.isBoldFont ( this );
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public WebLabel setItalicFont ()
    {
        return SwingUtils.setItalicFont ( this );
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public WebLabel setItalicFont ( boolean apply )
    {
        return SwingUtils.setItalicFont ( this, apply );
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean isItalicFont ()
    {
        return SwingUtils.isItalicFont ( this );
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public WebLabel setFontStyle ( boolean bold, boolean italic )
    {
        return SwingUtils.setFontStyle ( this, bold, italic );
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public WebLabel setFontStyle ( int style )
    {
        return SwingUtils.setFontStyle ( this, style );
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public WebLabel setFontSize ( int fontSize )
    {
        return SwingUtils.setFontSize ( this, fontSize );
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public WebLabel changeFontSize ( int change )
    {
        return SwingUtils.changeFontSize ( this, change );
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public int getFontSize ()
    {
        return SwingUtils.getFontSize ( this );
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public WebLabel setFontSizeAndStyle ( int fontSize, boolean bold, boolean italic )
    {
        return SwingUtils.setFontSizeAndStyle ( this, fontSize, bold, italic );
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public WebLabel setFontSizeAndStyle ( int fontSize, int style )
    {
        return SwingUtils.setFontSizeAndStyle ( this, fontSize, style );
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public WebLabel setFontName ( String fontName )
    {
        return SwingUtils.setFontName ( this, fontName );
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String getFontName ()
    {
        return SwingUtils.getFontName ( this );
    }

    /**
     * Size methods.
     */

    /**
     * {@inheritDoc}
     */
    @Override
    public int getPreferredWidth ()
    {
        return SizeUtils.getPreferredWidth ( this );
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public WebLabel setPreferredWidth ( int preferredWidth )
    {
        return SizeUtils.setPreferredWidth ( this, preferredWidth );
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public int getPreferredHeight ()
    {
        return SizeUtils.getPreferredHeight ( this );
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public WebLabel setPreferredHeight ( int preferredHeight )
    {
        return SizeUtils.setPreferredHeight ( this, preferredHeight );
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public int getMinimumWidth ()
    {
        return SizeUtils.getMinimumWidth ( this );
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public WebLabel setMinimumWidth ( int minimumWidth )
    {
        return SizeUtils.setMinimumWidth ( this, minimumWidth );
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public int getMinimumHeight ()
    {
        return SizeUtils.getMinimumHeight ( this );
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public WebLabel setMinimumHeight ( int minimumHeight )
    {
        return SizeUtils.setMinimumHeight ( this, minimumHeight );
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Dimension getPreferredSize ()
    {
        return SizeUtils.getPreferredSize ( this, super.getPreferredSize () );
    }
}